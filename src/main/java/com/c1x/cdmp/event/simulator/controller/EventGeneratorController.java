package com.c1x.cdmp.event.simulator.controller;

import com.c1x.cdmp.event.simulator.services.EventGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/simulate")
public class EventGeneratorController {
    private final EventGeneratorService eventGeneratorService;
    @GetMapping("/triggered/{count}")
    public void generateEvents(@PathVariable(name = "count") @NotNull int count) {
        log.info("Generating and printing {} events...", count);

        Flux<Void> result = eventGeneratorService.generateAndSendRandomEvents(count)
                .doOnNext(event -> {
                    // Log the event details (customize as needed)
                    log.info("Generated event: {}", event);
                });

        // Subscribe to trigger the processing
        result.subscribe();
    }

}