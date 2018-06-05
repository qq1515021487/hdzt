package com.bnuz.configuration;

import com.bnuz.entity.ActivityEntity;
import com.bnuz.entity.dto.ActivityDto;
import com.bnuz.entity.vo.ActivityVo;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @create by QuanQqqqq
 * @date 2018-6-1
 * 用于视图层的类型转换，主要是将DTO转成VO，
 * 运用到Dozer的包装类，这里将bean注入到spring容器中
 *
 */
@Configuration
public class DozerBeanMapperConfigure {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(beanMappingDtoVoBuilder);
        return mapper;
    }


    BeanMappingBuilder beanMappingDtoVoBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {
            // 配置将activity的dto转成vo
            mapping(ActivityDto.class, ActivityVo.class, TypeMappingOptions.oneWay())
                    .fields("cityEntity.name", "cityName")
                    .fields("cityEntity.cityId", "cityId");
        }
    };
}
