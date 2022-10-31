package com.pickban.ggbackend.recommendpick.domain.processor;

import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.domain.processor.mapper.ChampionMapper;
import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import com.pickban.ggbackend.recommendpick.dto.ChampionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class ChampionProcessorImpl implements ChampionProcessor{

    private final ChampionRepository championRepository;
    private final ChampionMapper championMapper;

    @Override
    public List<ChampionResponseDto> getCounter(String emLineChamp) {
        Champion champion = championRepository.findByChampId(Long.valueOf(emLineChamp))
                .orElseThrow(() -> new NullPointerException("Not Found Champion!!"));
        List<Long> counterList = champion.getChampCounterList();
        List<ChampionResponseDto> championResponseDtoList = new ArrayList<>();
        counterList.forEach(champId -> {
            championResponseDtoList.add(
                    championMapper.championToChampionResponseDto(
                            championRepository.findByChampId(champId)
                                    .orElseThrow(() -> new NullPointerException("Not Found Champion!!!"))));
        });
        return championResponseDtoList;
    }

    @Override
    public List<ChampionResponseDto> getTopTier(String line) {
        List<Champion> championList = championRepository.findByPositionAndChampTier(line, "1Tier");
        return championMapper.championListToChampionResponseDtoList(championList);
    }

    @Override
    public List<ChampionResponseDto> getMiddleTier(String line) {
        List<Champion> championList = championRepository.findByPositionAndChampTier(line, "2Tier");
        return championMapper.championListToChampionResponseDtoList(championList);
    }
}
