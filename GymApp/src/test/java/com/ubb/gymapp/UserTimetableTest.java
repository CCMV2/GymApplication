package com.ubb.gymapp;

import com.ubb.gymapp.model.*;
import com.ubb.gymapp.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTimetableTest {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WorkoutRepository workRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private TimetableRepository timeRepo;

    @Autowired
    private UserTimetableRepository userTimetableRepository;

    @Test
    public void addUserTimetable(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        UserTimetable userTimetable = new UserTimetable(user, pro);
        userTimetable = userTimetableRepository.save(userTimetable);
        assertNotNull(userTimetableRepository.findOne(userTimetable.getId()));
        userTimetableRepository.delete(userTimetable);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);

    }

    @Transactional
    @Test
    public void FindOne(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        UserTimetable userTimetable = new UserTimetable(user, pro);
        userTimetable = userTimetableRepository.save(userTimetable);
        assertEquals(userTimetableRepository.findOne(userTimetable.getId()), userTimetable);
        userTimetableRepository.delete(userTimetable);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);

    }

    @Test
    public void testDelete(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        UserTimetable userTimetable = new UserTimetable(user, pro);
        userTimetable = userTimetableRepository.save(userTimetable);
        userTimetableRepository.delete(userTimetable);
        assertNull(userTimetableRepository.findOne(userTimetable.getId()));
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);

    }

    @Transactional
    @Test
    public void Update(){
        Client user = new Client("a","a","a","a","a");
        Client user2 = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        UserTimetable userTimetable = new UserTimetable(user, pro);
        userTimetable = userTimetableRepository.save(userTimetable);
        userTimetable.setUser(user2);
        userTimetableRepository.save(userTimetable);
        UserTimetable userTimetable2 = userTimetableRepository.findOne(userTimetable.getId());
        assertEquals(userTimetable,userTimetable2);
        userTimetableRepository.delete(userTimetable);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(user2);
        userRepo.delete(trainer);
    }

    @Transactional
    @Test
    public void findAll(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        UserTimetable userTimetable = new UserTimetable(user, pro);
        UserTimetable userTimetable2 = new UserTimetable(user, pro);
        UserTimetable userTimetable3 = new UserTimetable(user, pro);
        userTimetable = userTimetableRepository.save(userTimetable);
        userTimetable2 = userTimetableRepository.save(userTimetable2);
        userTimetable3 = userTimetableRepository.save(userTimetable3);
        List<UserTimetable> list = userTimetableRepository.findAll();
        assertThat(list,hasItems(userTimetable,userTimetable2,userTimetable3));
        userTimetableRepository.delete(userTimetable);
        userTimetableRepository.delete(userTimetable2);
        userTimetableRepository.delete(userTimetable3);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);
    }

    @Test
    public void deleteByUser(){
        Client user = new Client("a","a","a","a","a");
        user = userRepo.save(user);

        Date dat=new Date();
        Workout work = new Workout();
        work.setWorkoutType("r");
        Room room = new Room();
        Trainer trainer = new Trainer("1234","1234","1234","1234","1234",null);
        userRepo.save(trainer);
        workRepo.save(work);
        roomRepo.save(room);
        assertNotNull(work);
        assertNotNull(room);
        assertNotNull(user);
        Timetable pro =new Timetable("Joi", dat, 2L, room, work);
        pro.setTrainer(trainer);
        timeRepo.save(pro);
        assertNotNull(pro.getId());
        UserTimetable userTimetable = new UserTimetable(user, pro);
        userTimetable = userTimetableRepository.save(userTimetable);
        long id = userTimetable.getId();
        userTimetableRepository.deleteByUser(user);
        boolean isDeleted = !userTimetableRepository.exists(id);
        assertTrue(isDeleted);
        timeRepo.delete(pro);
        workRepo.delete(work);
        roomRepo.delete(room);
        userRepo.delete(user);
        userRepo.delete(trainer);
    }
}