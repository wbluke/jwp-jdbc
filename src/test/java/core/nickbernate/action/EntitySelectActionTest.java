package core.nickbernate.action;

import core.nickbernate.annotation.Entity;
import next.model.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EntitySelectActionTest {

    @DisplayName("Select Query 생성하기")
    @Test
    void createSelectQuery() {
        /* given */
        Class<User> entityClass = User.class;
        String entityId = "testId";

        /* when */
        EntitySelectAction selectAction = new EntitySelectAction(entityClass, entityId);

        /* then */
        assertThat(selectAction.getQuery()).isEqualTo(String.format("SELECT userId, password, name, email FROM %s WHERE userId='testId'", getEntityTableName(User.class)));

    }

    private String getEntityTableName(Class<?> entityClass) {
        Entity entityClassAnnotation = entityClass.getAnnotation(Entity.class);

        return StringUtils.isEmpty(entityClassAnnotation.table()) ? entityClass.getSimpleName() : entityClassAnnotation.table();
    }

}
