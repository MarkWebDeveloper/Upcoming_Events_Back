package veroslaves.upcoming_events_back.events;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/* 
 * By default, tests annotated with @DataJpaTest are transactional and roll back at the end of each test. If you don’t want it, you can disable transaction management for a test or for the whole class using @Transactional annotation
 * 
 * @Transactional(propagation = Propagation.NOT_SUPPORTED)
 * 
 * In-memory embedded database (like H2 database in this example) generally works well for tests, it is fast and does not require any installation. However, we can configure for a real database with @AutoConfigureTestDatabase
 *
 * @AutoConfigureTestDatabase(replace=Replace.NONE)
 */

@DataJpaTest
public class EventRepositoryTest {
    
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    EventRepository repository;

    @Test
    @DisplayName("Find all events")
    void testGetAllEvents() {
        List<Event> events = repository.findAll();
        assertThat(events.get(0).getEvent_title()).isEqualTo("Fiesta de los oricios");
    }

    @Test
    @DisplayName("Find event by id")
    void testGetOneEventById() {
        Event france = repository.findById(2L).orElseThrow();
        // assertEquals(2L, france.getId());
        // assertEquals("France", france.getName());
    }
}
