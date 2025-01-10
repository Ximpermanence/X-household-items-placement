package com.ch.houseitemplace.controller;

import com.ch.houseitemplace.pojo.entity.room.Room;
import com.ch.houseitemplace.service.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 房间 前端控制器
 * </p>
 *
 * @author Ximpermanence
 * @since 2025-01-10
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    // 生成增删改查接口
    @GetMapping("list")
    public List<Room> list() {
        return roomService.list();
    }

    @GetMapping("get")
    public Room get() {
        return roomService.getById(1);
    }

    @GetMapping("save")
    public void save(Room room) {
        roomService.save(room);
    }

    @GetMapping("update")
    public void update(Room room) {
        roomService.updateById(room);
    }

    @GetMapping("remove")
    public void remove(List<Long> ids) {
        roomService.removeByIds(ids);
    }


}
