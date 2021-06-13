package com.micro.ege.offer.offermicro.repo;

import com.micro.ege.offer.offermicro.config.JpaConfig;
import com.micro.ege.offer.offermicro.core.utils.OfferUtils;
import com.micro.ege.offer.offermicro.dto.CreateOfferDto;
import com.micro.ege.offer.offermicro.dto.ListOfferDto;
import com.micro.ege.offer.offermicro.dto.OfferDetails;
import com.micro.ege.offer.offermicro.dto.ServiceOfferDto;
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
public class OfferRepositoryImpl implements OfferRepository{
    @Value("classpath:sql/get_offer.sql")
    private Resource getOfferResource;
    @Value("classpath:sql/get_offer_with_offerid.sql")
    private Resource getOfferWithOfferIdResource;
    @Value("classpath:sql/create_offer.sql")
    private Resource createOfferResource;
    @Value("classpath:sql/update_offer.sql")
    private Resource updateOfferResource;
    @Value("classpath:sql/delete_offer.sql")
    private Resource deleteOfferResource;
    @Value("classpath:sql/list_offer_only_prov.sql")
    private Resource listOfferOnlyProviderResource;
    @Value("classpath:sql/list_offer_only_adv.sql")
    private Resource listOfferOnlyAdvertResource;
    @Value("classpath:sql/list_offer_prov_stat.sql")
    private Resource listOfferProviderStatResource;
    @Value("classpath:sql/list_offer_only_prov.sql")
    private Resource listOfferAdvertStatResource;
    @Value("classpath:sql/list_offer_all.sql")
    private Resource listOfferResource;


    private static final BeanPropertyRowMapper<ServiceOfferDto>
            SERVICE_OFFER_DTO_BEAN_PROPERTY_ROW_MAPPER = new
            BeanPropertyRowMapper<>(ServiceOfferDto.class);
    private static final BeanPropertyRowMapper<OfferDetails>
            OFFER_DETAILS_BEAN_PROPERTY_ROW_MAPPER = new
            BeanPropertyRowMapper<>(OfferDetails.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public OfferRepositoryImpl() {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JpaConfig()
                .getDataSource());
    }
    @Override
    public ServiceOfferDto getOfferWithOfferId(String offerId) {
        try{
            final String getOffer = StreamUtils.copyToString(
                    getOfferWithOfferIdResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("offerId", offerId, Types.VARCHAR);
            return namedParameterJdbcTemplate.queryForObject(getOffer,
                    parameterSource,SERVICE_OFFER_DTO_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public ServiceOfferDto getOfferWithProviderIdAndTime(String serviceProviderID, Integer offerTime) {
        try{
            final String getOffer = StreamUtils.copyToString(
                    getOfferResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceProviderID", serviceProviderID, Types.VARCHAR)
                    .addValue("offerTime",offerTime,Types.INTEGER);
            return namedParameterJdbcTemplate.queryForObject(getOffer,
                    parameterSource,SERVICE_OFFER_DTO_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean createOffer(CreateOfferDto createOfferDto) {
        try{
            final String createOffer = StreamUtils.copyToString(
                    createOfferResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("offerID", OfferUtils.generateOfferID(), Types.VARCHAR)
                    .addValue("serviceProviderID", createOfferDto.getServiceProviderID(), Types.VARCHAR)
                    .addValue("advertID", createOfferDto.getAdvertID(), Types.VARCHAR)
                    .addValue("freeText", createOfferDto.getFreeText(), Types.VARCHAR)
                    .addValue("serviceStatus", createOfferDto.getServiceStatus(), Types.SMALLINT)
                    .addValue("offerTime", createOfferDto.getOfferTime(), Types.INTEGER);

            int affectedRows = namedParameterJdbcTemplate.
                    update(createOffer, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean updateOffer(String offerId, String freeText, Short serviceStatus, Integer offerTime) {
        try {
        final String updateOffer;
            updateOffer = StreamUtils.copyToString(
                    updateOfferResource.getInputStream(), Charset.defaultCharset());

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("offerId", offerId, Types.VARCHAR)
                    .addValue("freeText", freeText, Types.VARCHAR)
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("offerTime", offerTime, Types.INTEGER);

            int affectedRows = namedParameterJdbcTemplate.update(updateOffer, parameterSource);
            return affectedRows != 0 ;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteOffer(String offerId) {
        try{
            final String deleteOffer = StreamUtils.copyToString(
                    deleteOfferResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("offerId", offerId, Types.VARCHAR);

            int affectedRows = namedParameterJdbcTemplate.
                    update(deleteOffer, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<OfferDetails> listOfferWithAdvert(String advertId) {
        try{
            final String  listOfferOnlyAdvert = StreamUtils.copyToString(
                    listOfferOnlyAdvertResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("advertId", advertId, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listOfferOnlyAdvert,
                    parameterSource,OFFER_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OfferDetails> listOfferWithProvider(String providerId) {
        try{
            final String  listOfferOnlyProvider = StreamUtils.copyToString(
                    listOfferOnlyProviderResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("providerId", providerId, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listOfferOnlyProvider,
                    parameterSource,OFFER_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OfferDetails> listOfferWithAdvertAndStat(String advertId, short serviceStatus) {
        try{
            final String  listOfferAdvertStat = StreamUtils.copyToString(
                    listOfferAdvertStatResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("advertId", advertId, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listOfferAdvertStat,
                    parameterSource,OFFER_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OfferDetails> listOfferWithProviderAndStat(String providerId, short serviceStatus) {
        try{
            final String  listOfferProviderStat = StreamUtils.copyToString(
                    listOfferProviderStatResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("providerId", providerId, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listOfferProviderStat,
                    parameterSource,OFFER_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OfferDetails> listOffer(String providerId, String advertId, short serviceStatus) {
        try{
            final String  listOffer = StreamUtils.copyToString(
                    listOfferResource.getInputStream(), Charset.defaultCharset());
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("serviceStatus", serviceStatus, Types.SMALLINT)
                    .addValue("advertId", advertId, Types.VARCHAR)
                    .addValue("providerId", providerId, Types.VARCHAR);
            return namedParameterJdbcTemplate.query(listOffer,
                    parameterSource,OFFER_DETAILS_BEAN_PROPERTY_ROW_MAPPER);
        } catch (IOException | EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
