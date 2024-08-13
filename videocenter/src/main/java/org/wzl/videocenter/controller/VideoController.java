package org.wzl.videocenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.wzl.videocenter.service.VideoService;
import org.wzl.videocenter.utils.Resp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("/video")
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    @GetMapping("/getAll")
    public Resp<?> getAll() {
        return Resp.ok(videoService.getAll());
    }

    @GetMapping("/getVideoPage/{page}/{size}")
    public Resp<?> getVideoPage(@PathVariable double page,
                                @PathVariable double size) {
        return Resp.ok();
    }

}
