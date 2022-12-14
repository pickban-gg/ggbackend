package com.pickban.ggbackend.recommendpick.presentation;


import com.google.gson.Gson;
import com.pickban.ggbackend.recommendpick.application.RecommendPickFacade;
import com.pickban.ggbackend.recommendpick.domain.MockDataSave;
import com.pickban.ggbackend.recommendpick.dto.ProgamerPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendPickDto;
import com.pickban.ggbackend.recommendpick.dto.RecommendRequestDto;
import com.pickban.ggbackend.recommendpick.utill.ApiParamEnum;
import com.pickban.ggbackend.recommendpick.utill.RecommendDtoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;

import org.junit.jupiter.api.TestFactory;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.stream.Stream;

import static com.pickban.ggbackend.ApiDocumentUtils.getRequestPreProcessor;
import static com.pickban.ggbackend.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendPickApi.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class RecommendPickApiTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private RecommendPickFacade recommendPickFacade;

    @MockBean
    private MockDataSave mockDataSave;

    @InjectMocks
    private RecommendDtoFactory recommendDtoFactory;


    @DisplayName("?????? ?????? ????????? Presentation Layer")
    @TestFactory
    Stream<DynamicTest> dynamicTests(){

        final List<RecommendPickDto> recommendPickDtoList =
                recommendDtoFactory.createRecommendPickDtoMid();

        final List<ProgamerPickDto> progamerPickDtoList =
                recommendDtoFactory.createProgamerPickDtoMid();

        final String team = ApiParamEnum.TEAM.get();
        final String line = ApiParamEnum.LINE.get();
        final String bans = ApiParamEnum.BANS.get();
        final String emBans = ApiParamEnum.EM_BANS.get();
        final String picks = ApiParamEnum.PICKS.get();
        final String emPicks = ApiParamEnum.EM_PICKS.get();

        return Stream.of(
                DynamicTest.dynamicTest("?????? ?????? ???????????? ????????????.",
                        ()->{
                    given(recommendPickFacade.getRecommend(
                            Mockito.anyString(),
                            Mockito.anyString(),
                            Mockito.any(RecommendRequestDto.class))).willReturn(recommendPickDtoList);
                    ResultActions actions = mockMvc.perform(
                            get("/api/recommend")
                                    .param("team", team)
                                    .param("line", line)
                                    .param("bans", bans)
                                    .param("emBans", emBans)
                                    .param("picks", picks)
                                    .param("emPicks",emPicks)
                                    .accept(MediaType.APPLICATION_JSON)
                                    .contentType(MediaType.APPLICATION_JSON)
                            );
                    actions.andExpect(status().isOk())
                            .andDo(document(
                                    "get-recommend",
                                    getRequestPreProcessor(),
                                    getResponsePreProcessor(),
                                    requestParameters(
                                            parameterWithName("team").description("??? ?????? (????????????) value=[B, R]"),
                                            parameterWithName("line").description("???????????? (????????????) value=[top, jg, mid, adc, sup]"),
                                            parameterWithName("bans").description("?????? ??? ??????????????? (????????????)").optional(),
                                            parameterWithName("emBans").description("?????? ??? ??????????????? (????????????)").optional(),
                                            parameterWithName("picks").description("?????? ??????????????? (????????????)").optional(),
                                            parameterWithName("emPicks").description("?????? ??????????????? (????????????)").optional()
                                    ),
                                    responseFields(
                                            fieldWithPath("[]").type(JsonFieldType.ARRAY).description("?????? ????????? ??????"),
                                            fieldWithPath("[].championId").type(JsonFieldType.NUMBER).description("?????? ????????? ID"),
                                            fieldWithPath("[].championTier").type(JsonFieldType.STRING).description("?????? ????????? ??????")
                                    )
                            ));

                }),
                DynamicTest.dynamicTest("????????????????????? ?????? ???????????? ????????????.",
                        ()->{
                            given(recommendPickFacade.getRecommendProgamer(
                                    Mockito.anyString(),
                                    Mockito.anyString(),
                                    Mockito.any(RecommendRequestDto.class))).willReturn(progamerPickDtoList);
                            ResultActions actions = mockMvc.perform(
                                    get("/api/recommend/progamer")
                                            .param("team", team)
                                            .param("line", line)
                                            .param("bans", bans)
                                            .param("emBans", emBans)
                                            .param("picks", picks)
                                            .param("emPicks",emPicks)
                                            .accept(MediaType.APPLICATION_JSON)
                                            .contentType(MediaType.APPLICATION_JSON)
                            );
                            actions.andExpect(status().isOk())
                                    .andDo(document(
                                            "get-recommend-progamer",
                                            getRequestPreProcessor(),
                                            getResponsePreProcessor(),
                                            requestParameters(
                                                    parameterWithName("team").description("??? ?????? (????????????) value=[B, R]"),
                                                    parameterWithName("line").description("???????????? (????????????) value=[top, jg, mid, adc, sup]"),
                                                    parameterWithName("bans").description("?????? ??? ??????????????? (????????????)").optional(),
                                                    parameterWithName("emBans").description("?????? ??? ??????????????? (????????????)").optional(),
                                                    parameterWithName("picks").description("?????? ??????????????? (????????????)").optional(),
                                                    parameterWithName("emPicks").description("?????? ??????????????? (????????????)").optional()
                                            ),
                                            responseFields(
                                                    fieldWithPath("[]").type(JsonFieldType.ARRAY).description("?????? ??????????????? ??????"),
                                                    fieldWithPath("[].progamerName").type(JsonFieldType.STRING).description("??????????????? ??????"),
                                                    fieldWithPath("[].progamerNickname").type(JsonFieldType.STRING).description("??????????????? ?????????"),
                                                    fieldWithPath("[].recommendPickDto").type(JsonFieldType.OBJECT).description("??????????????? ?????? ?????????"),
                                                    fieldWithPath("[].recommendPickDto.championId").type(JsonFieldType.NUMBER).description("??????????????? ????????? ID"),
                                                    fieldWithPath("[].recommendPickDto.championTier").type(JsonFieldType.STRING).description("??????????????? ????????? ??????")
                                            )
                                    ));

                        })
        );
    }
}
