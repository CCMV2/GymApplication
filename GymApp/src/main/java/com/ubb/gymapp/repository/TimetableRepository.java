package com.ubb.gymapp.repository;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> branch 'develop' of https://github.com/ProiectColectivIG3/GymApplication.git
import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long>{
<<<<<<< HEAD
	
	List<Timetable> findByDay(String day);
	List<Timetable> findByidTimetable(int id);
	List<Timetable> findByidWorkout(int id);
	List<Timetable> findByroom_idroom(int id);
	
	void deleteInTimetable(List<Timetable> entities);
	
}
=======

}



>>>>>>> branch 'develop' of https://github.com/ProiectColectivIG3/GymApplication.git
