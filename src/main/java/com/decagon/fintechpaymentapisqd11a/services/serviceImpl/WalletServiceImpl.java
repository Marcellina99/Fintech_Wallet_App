package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.request.FlwWalletRequest;
import com.decagon.fintechpaymentapisqd11a.response.FlwVirtualAccountResponse;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import com.decagon.fintechpaymentapisqd11a.util.Constant;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class WalletServiceImpl implements WalletService {


    @Override
    public Wallet createWallet(FlwWalletRequest walletRequest) throws JSONException {

        //You use this when we want to consume api
        RestTemplate restTemplate = new RestTemplate();
        //To use this to integrate the json objects that was converted into pojo
        HttpHeaders headers = new HttpHeaders();
        //this is used to accept json content
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //pass the authorization secret that was generated when you registered with flutterwave
        headers.add("Authorization", "Bearer " + Constant.AUTHORIZATION);

        //called the payload method
        FlwWalletRequest payload = generatePayload(walletRequest);
        //Httpentity represents an http request or response entity, consisting of headers and body.
        HttpEntity<FlwWalletRequest> request = new HttpEntity<>(payload, headers);

        FlwVirtualAccountResponse body = restTemplate.exchange(
                //virtual account link
                Constant.CREATE_VIRTUAL_ACCOUNT_API,
                //it is a post method
                HttpMethod.POST,
                //this houses the headers and the payload(the request we will send to the client)
                request,
                //the pojo gotten from flutterwave
                FlwVirtualAccountResponse.class
        ).getBody();

        Wallet wallet = Wallet.builder()
                .bankName(body.getData().getBankName())
                .acctNumber(body.getData().getAccountNumber())
                .balance(Double.parseDouble(body.getData().getAmount()))
                .build();

        return wallet;
    }

    private FlwWalletRequest generatePayload(FlwWalletRequest flwWalletRequest){
        FlwWalletRequest jsonData = FlwWalletRequest.builder()
                .firstname(flwWalletRequest.getFirstname())
                .lastname(flwWalletRequest.getLastname())
                .email(flwWalletRequest.getEmail())
                .bvn(flwWalletRequest.getBvn())
                .is_permanent(true)
                .phonenumber(flwWalletRequest.getPhonenumber())
                .tx_ref("FinTech Payment App SQ-11A")
                .narration("Payment")
                .build();

            return jsonData;
    }

}
