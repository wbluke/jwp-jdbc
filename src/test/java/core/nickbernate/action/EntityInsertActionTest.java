package core.nickbernate.action;

import core.nickbernate.TestEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EntityInsertActionTest {

    @DisplayName("Insert Query 생성하기")
    @Test
    void createSelectQuery() {
        /* given */
        TestEntity testEntity = new TestEntity("testId", "testName");

        /* when */
        EntityInsertAction entityInsertAction = new EntityInsertAction(testEntity);

        /* then */
        assertThat(entityInsertAction.getQuery()).isEqualTo(
                String.format("INSERT INTO %s VALUES ('testId', 'testName')", TestEntity.getTableName())
        );
    }

}
