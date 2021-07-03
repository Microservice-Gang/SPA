package com.micro.ege.advert.advertservice.repo;

import com.micro.ege.advert.advertservice.dto.CreateAdvertDto;
import com.micro.ege.advert.advertservice.dto.ServiceAdvertDto;
import com.micro.ege.advert.advertservice.dto.AdvertDetailsDto;
import com.micro.ege.advert.advertservice.config.JpaConfig;
import com.micro.ege.advert.advertservice.core.utils.AdvertUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Types;
import java.util.List;

@Repository
public class AdvertRepositoryImpl implements AdvertRepository{
    @Value("classpath:sql/get_advert.sql")
    private Resource getAdvertResource;
    @Value("classpath:sql/get_advert_with_advert_id.sql")
    private Resource getAdvertWithAdvertIdResource;
    @Value("classpath:sql/create_advert.sql")
    private Resource createAdvertResource;
    @Value("classpath:sql/update_advert.sql")
    private Resource updateAdvertResource;
    @Value("classpath:sql/delete_advert.sql")
    private Resource deleteAdvertResource;
    @Value("classpath:sql/list_advert_only_provider.sql")
    private Resource listAdvertOnlyProviderResource;
    @Value("classpath:sql/list_advert_prov_stat.sql")
    private Resource listAdvertProviderStatResource;
    @Value("classpath:sql/list_advert_only_prov.sql")
    private Resource listAdvertAdvertStatResource;
    @Value("classpath:sql/list_advert_all.sql")
    private Resource listAdvertResource;
    @Value("classpath:sql/list_advert_only_name.sql")
    private Resource listAdvertWithNameResource;
    @Value("classpath:sql/list_advert_only_name.sql")
    private Resource getAdvertWithProviderIdResource;
    @Value("classpath:sql/list_advert_only_price.sql")
    private Resource listAdvertWithPriceResource;

    private static final BeanPropertyRowMapper<ServiceAdvertDto>
            SERVICE_ADVERT_DTO_BEAN_PROPERTY_ROW_MAPPER = new
            BeanPropertyRowMapper<>(ServiceAdvertDto.class);
    private static final BeanPropertyRowMapper<AdvertDetailsDto>
            ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER = new
            BeanPropertyRowMapper<>(AdvertDetailsDto.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public AdvertRepositoryImpl() {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JpaConfig()
                .getDataSource());
    }


    @Override
    public ServiceAdvertDto getAdvertWithAdvertId(String advertId) {
        try{
            final String getOffer = StreamUtils.copyToString(
                    getAdvertWithAdvertIdResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("advertId", advertId, Types.VARCHAR);
            return namedParameterJdbcTemplate.queryForObject(getOffer,
                    parameterSource,SERVICE_ADVERT_DTO_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ServiceAdvertDto getAdvertWithProviderId(String serviceProviderID, short serviceStatus) {
        try{
            final String getAdvertWithProviderId = StreamUtils.copyToString(
                    getAdvertWithProviderIdResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceProviderID", serviceProviderID, Types.VARCHAR)
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT);
            return namedParameterJdbcTemplate.queryForObject(getAdvertWithProviderId,
                    parameterSource,SERVICE_ADVERT_DTO_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ServiceAdvertDto getAdvertWithProviderIdAndTime(String serviceProviderID, Integer advertTime) {
        try{
            final String getAdvert = StreamUtils.copyToString(
                    getAdvertResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceProviderID", serviceProviderID, Types.VARCHAR)
                    .addValue("advertTime",advertTime,Types.INTEGER);
            return namedParameterJdbcTemplate.queryForObject(getAdvert,
                    parameterSource,SERVICE_ADVERT_DTO_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdvertDetailsDto> listAdvertWithAdvertAndStat(String advertID, Short serviceStatus) {
        try{
            final String  listAdvertProviderStat = StreamUtils.copyToString(
                    listAdvertAdvertStatResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("advertID", advertID, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listAdvertProviderStat,
                    parameterSource,ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdvertDetailsDto> listAdvertWithPrice(Integer minPrice) {
        try{
            final String listAdvertWithPrice = StreamUtils.copyToString(
                    listAdvertWithPriceResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("minimumPrice", minPrice, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listAdvertWithPrice,
                    parameterSource,ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdvertDetailsDto> listAdvertWithProviderAndStat(String serviceProviderID, Short serviceStatus) {
        try{
            final String  listAdvertProviderStat = StreamUtils.copyToString(
                    listAdvertProviderStatResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("providerId", serviceProviderID, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listAdvertProviderStat,
                    parameterSource,ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Boolean createAdvert(CreateAdvertDto createAdvertDto) {
        try{
            final String createAdvert = StreamUtils.copyToString(
                    createAdvertResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("advertID", AdvertUtils.generateAdvertID(), Types.VARCHAR)
                    .addValue("serviceProviderID", createAdvertDto.getServiceProviderID(), Types.VARCHAR)
                    .addValue("advertID", createAdvertDto.getAdvertID(), Types.VARCHAR)
                    .addValue("summary", createAdvertDto.getSummary(), Types.VARCHAR)
                    .addValue("serviceStatus", createAdvertDto.getServiceStatus(), Types.SMALLINT)
                    .addValue("advertTime", createAdvertDto.getAdvertCreateTime(), Types.INTEGER)
                    .addValue("minPrice", createAdvertDto.getMinPrice(), Types.INTEGER);

            int affectedRows = namedParameterJdbcTemplate.
                    update(createAdvert, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateAdvert(String advertName, String advertId, String summary, Short serviceStatus, Integer createdAdvertTime, Integer minPrice) {
        try {
            final String updateAdvert;
            updateAdvert = StreamUtils.copyToString(
                    updateAdvertResource.getInputStream(), Charset.defaultCharset());

            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("offerName", advertName, Types.VARCHAR)
                    .addValue("offerId", advertId, Types.VARCHAR)
                    .addValue("summary", summary, Types.VARCHAR)
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("advertTime", createdAdvertTime, Types.INTEGER)
                    .addValue("minPrice", minPrice, Types.INTEGER);


            int affectedRows = namedParameterJdbcTemplate.update(updateAdvert, parameterSource);
            return affectedRows != 0 ;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<AdvertDetailsDto> listAdvertWithName(String advertName){
        try{
            final String  listAdvertWithName = StreamUtils.copyToString(
                    listAdvertWithNameResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("advertName", advertName, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listAdvertWithName,
                    parameterSource,ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteAdvert(String advertId) {
        try{
            final String deleteAdvert = StreamUtils.copyToString(
                    deleteAdvertResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("advertId", advertId, Types.VARCHAR);

            int affectedRows = namedParameterJdbcTemplate.
                    update(deleteAdvert, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }


    @Override
    public List<AdvertDetailsDto> listAdvertWithProvider(String providerId) {
        try{
            final String  listAdvertOnlyProvider = StreamUtils.copyToString(
                    listAdvertOnlyProviderResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("providerId", providerId, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listAdvertOnlyProvider,
                    parameterSource,ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public List<AdvertDetailsDto> listAdvert(String providerId, String advertId, Integer minPrice, short serviceStatus) {
        try{
            final String  listAdvert = StreamUtils.copyToString(
                    listAdvertResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("minPrice", minPrice, Types.INTEGER)
                    .addValue("advertId", advertId, Types.VARCHAR)
                    .addValue("providerId", providerId, Types.VARCHAR)
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT);
            return namedParameterJdbcTemplate.query(listAdvert,
                    parameterSource,ADVERT_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
