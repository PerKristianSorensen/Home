package pk.home.training.impl.repository;

import static pk.home.training.jooq.tables.Users.USERS;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import pk.home.training.api.dto.UserDto;

@Singleton
public class UserRepository {

    private final DSLContext dsl;

    @Inject
    public UserRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public UserDto findById(Long id) {
        Record record = dsl.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchOne();
        return record != null ? mapToUserDto(record) : null;
    }

    public void save(UserDto userDto) {
        dsl.insertInto(USERS)
                .set(USERS.NAME, userDto.getName())
                .set(USERS.EMAIL, userDto.getEmail())
                .execute();
    }

    public void delete(Long id) {
        dsl.deleteFrom(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }

    private UserDto mapToUserDto(Record record) {
        UserDto userDto = new UserDto();
        userDto.setId(record.get(USERS.ID));
        userDto.setName(record.get(USERS.NAME));
        userDto.setEmail(record.get(USERS.EMAIL));
        return userDto;
    }
}