package com.micro.ege.user.usermicro.repo;

import com.micro.ege.user.usermicro.config.JpaConfig;
import com.micro.ege.user.usermicro.core.utils.UserUtils;
import com.micro.ege.user.usermicro.dto.CreateUserDto;
import com.micro.ege.user.usermicro.dto.UserDetailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;
import java.sql.Types;

@Repository
public class UserRepositoryImpl implements UserRepository{
    String createUser = "INSERT INTO public.\"USER\"(\n" +
            "    \"USER_ID\", \"NAME\", \"SURNAME\", \"MAIL\", \"CIPHER\")\n" +
            "VALUES (:userId, :name, :surname, :mail, :pass);";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositoryImpl() {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(new JpaConfig()
                .getDataSource());
    }

    @Override
    public UserDetailDto getUserWithId(String userId) {
        return null;
    }

    @Override
    public UserDetailDto getUserWithMail(String mail) {
        return null;
    }

    @Override
    public Boolean createUser(CreateUserDto createUserDto) {
        try{
            SqlParameterSource parameterSource = new MapSqlParameterSource()
                    .addValue("userId", UserUtils.generateUserID(), Types.VARCHAR)
                    .addValue("name", createUserDto.getName(), Types.VARCHAR)
                    .addValue("surname", createUserDto.getSurname(), Types.VARCHAR)
                    .addValue("mail", createUserDto.getMail(), Types.VARCHAR)
                    .addValue("pass", createUserDto.getCipher(), Types.VARCHAR);

            int affectedRows = namedParameterJdbcTemplate.
                    update(createUser, parameterSource);
            return affectedRows != 0 ;
        }catch (Exception e) {
            return false;
        }
    }

}
