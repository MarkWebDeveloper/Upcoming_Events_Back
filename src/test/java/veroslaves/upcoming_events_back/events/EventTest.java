package veroslaves.upcoming_events_back.events;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import veroslaves.upcoming_events_back.cities.City;
import veroslaves.upcoming_events_back.events.Event;

public class EventTest {

    Event event;

    @BeforeEach
    void setUp() throws ParseException {
        City event_city = new City();
        event_city.setCity_name("Gijón");

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String startDateString = "2022/12/23 12:50:00";
        String finishDateString = "2022/12/25 12:50:00";
        Date event_start = format.parse(startDateString);
        Date event_end = format.parse(finishDateString);

        // Date event_start = new Date;
        // Date event_end = new Date();
        event = new Event("Danzas al aire libre", event_start, event_end, null, 10L, "Muy interesante. Pero muy, muy...", event_city);
        event.setId(1L);
    }

    @Test
    void testEventHas8Attributes() {
        Field[] fields = event.getClass().getDeclaredFields();
        assertThat(fields.length, is(8));
    }

    @Test
    void testEventHasTitleStartDateFinishDateImageMaxParticipantsDescriptionAndCity() {
        assertThat(event.getId(), is(1L));
        assertThat(event.getEvent_title(), is("Danzas al aire libre"));
        assertThat(event.getEvent_image(), is(nullValue()));
        assertThat(event.getMax_participants(), is(10L));
        assertThat(event.getDescription(), is("Muy interesante. Pero muy, muy..."));
    }
}