package com.example.demo;

public class TestEs {
    //package com.framework.escontroller;
//
//import com.framework.info.BusinessException;
//import com.framework.info.ResultInfo;
//import com.framework.model.LabelNewsInfo;
//import com.framework.repository.LabelNewsInfoRepository;
//import org.apache.commons.lang3.StringUtils;
//import org.elasticsearch.action.update.UpdateRequest;
//import org.elasticsearch.action.update.UpdateResponse;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.data.elasticsearch.core.query.UpdateQuery;
//import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * es 增删改查
// * @author ldw
// * date 2021-07-13
// */
//@RestController
//@RequestMapping("/estest")
//public class EsTestController {
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//    @Autowired
//    private LabelNewsInfoRepository labelNewsInfoRepository;
//
//    @PostMapping("/queryLabelNewsInfo")
//    public ResultInfo<?> queryLabelNewsInfo(HttpServletRequest request, HttpServletResponse response
//    ) throws Exception {
//        BoolQueryBuilder builder = QueryBuilders.boolQuery();
//        builder.must(QueryBuilders.wildcardQuery("category.keyword", "教育"));
//        builder.must(QueryBuilders.wildcardQuery("citys.keyword", "*荆州*"));
//
//        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
//        nativeSearchQueryBuilder.withQuery(builder);
//        SearchQuery searchQuery = nativeSearchQueryBuilder
//                .withSort(SortBuilders.fieldSort("pubtime").order(SortOrder.DESC))
//                .withPageable(PageRequest.of(0, 10))
//                .build();
//
//        AggregatedPage<LabelNewsInfo> labelNewsInfos = elasticsearchTemplate.queryForPage(searchQuery, LabelNewsInfo.class);
//        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, labelNewsInfos);
//    }
//
//    @PostMapping("/addLabelNewsInfo")
//    public ResultInfo<?> addLabelNewsInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody LabelNewsInfo labelNewsInfo
//    ) throws Exception {
//        LabelNewsInfo save = labelNewsInfoRepository.save(labelNewsInfo);
//        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, save);
//    }
//
//    @PostMapping("/deleteLabelNewsInfoById")
//    public ResultInfo<?> deleteLabelNewsInfoById(HttpServletRequest request, HttpServletResponse response, String id
//    ) throws Exception {
//        if (StringUtils.isBlank(id)) {
//            throw new BusinessException(ResultInfo.FAILURE, ResultInfo.MSG_INVALID_PARAM);
//        }
//        labelNewsInfoRepository.deleteById(id);
//        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS);
//    }
//
//    @PostMapping("/updateLabelNewsInfo")
//    public ResultInfo<?> updateLabelNewsInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody LabelNewsInfo labelNewsInfo
//    ) throws Exception {
//        if (StringUtils.isBlank(labelNewsInfo.getId())) {
//            throw new BusinessException(ResultInfo.FAILURE, ResultInfo.MSG_INVALID_PARAM);
//        }
//
//        UpdateRequest updateRequest = new UpdateRequest();
//        updateRequest.doc(labelNewsInfo.toMap());
//        UpdateQueryBuilder updateQueryBuilder = new UpdateQueryBuilder();
//        updateQueryBuilder.withId(labelNewsInfo.getId());
//        updateQueryBuilder.withUpdateRequest(updateRequest);
//        updateQueryBuilder.withClass(LabelNewsInfo.class);
//
//        UpdateQuery build = updateQueryBuilder.build();
//        UpdateResponse update = elasticsearchTemplate.update(build);
//
//        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, update);
//    }
//
//
//}

}
