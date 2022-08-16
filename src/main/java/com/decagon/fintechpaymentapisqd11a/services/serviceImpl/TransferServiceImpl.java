package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.models.FlwBank;
import com.decagon.fintechpaymentapisqd11a.response.FlwGetAllBanksResponse;
import com.decagon.fintechpaymentapisqd11a.services.TransferService;
import com.decagon.fintechpaymentapisqd11a.util.Constant;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Override
    public List<FlwBank> getAllBanks() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer " + Constant.AUTHORIZATION);

        HttpEntity<FlwGetAllBanksResponse> httpEntity = new HttpEntity<>(null, httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        FlwGetAllBanksResponse getAllBanksResponse = restTemplate.exchange(
                Constant.GET_ALL_BANKS,
                HttpMethod.GET,
                httpEntity,
                FlwGetAllBanksResponse.class
        ).getBody();
        return getAllBanksResponse.getData();
    }
}