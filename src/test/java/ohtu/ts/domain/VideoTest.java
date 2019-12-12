package ohtu.ts.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Joonas
 */
public class VideoTest {

    Video video;
    String videoString;

    @Before
    public void setUp() {
        video = new Video(1, "C# Tutorial - Full Course for Beginners", "https://www.youtube.com/watch?v=GhQdlIFylQ8");
        videoString = new StringBuilder()
                .append("Tyyppi: Video, ")
                .append(String.format("Otsikko: %s, ", "C# Tutorial - Full Course for Beginners"))
                .append(String.format("URL: %s", "https://www.youtube.com/watch?v=GhQdlIFylQ8"))
                .toString();
    }

    @Test
    public void videoShouldBeCreatedWithGivenId() {
        assertEquals(1, video.getId(), 0);
        assertEquals("C# Tutorial - Full Course for Beginners", video.getTitle());
        assertEquals("https://www.youtube.com/watch?v=GhQdlIFylQ8", video.getUrl());
        assertEquals(video.getType(), Types.VIDEO);
    }
    
    @Test
    public void videoShouldBeCreatedWithoutGivenId() {
        video = new Video("Ep.08 - Machine Learning", "https://www.youtube.com/watch?v=eg5w2vYpGpo");
        assertEquals(null, video.getId());
        assertEquals("Ep.08 - Machine Learning", video.getTitle());
        assertEquals("https://www.youtube.com/watch?v=eg5w2vYpGpo", video.getUrl());
        assertEquals(video.getType(), Types.VIDEO);
    }
}
