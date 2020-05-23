package com.gildedrose;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @since 2020/5/24 12:40 AM
 */
public class GildedRoseSafeNetTest {

   @Test
   public void should_safe_net() throws URISyntaxException, IOException {
       URI resource = this.getClass().getClassLoader().getResource("base_line.text").toURI();
       Stream<String> lines = Files.lines(Paths.get(resource));
       String baseLine   = lines.map(String::toString).collect(Collectors.joining("\n"));
       assertThat(TextTestFixture.getBaseLine(), Is.is(baseLine));
   }
}