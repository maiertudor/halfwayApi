package com.ubb935.halfway;

import com.ubb935.halfway.controller.JobController;
import com.ubb935.halfway.model.Category;
import com.ubb935.halfway.model.Job;
import com.ubb935.halfway.model.Location;
import com.ubb935.halfway.repository.CategoryRepository;
import com.ubb935.halfway.repository.LocationRepository;
import com.ubb935.halfway.service.CategoryService;
import com.ubb935.halfway.service.JobService;
import com.ubb935.halfway.service.LocationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HalfwayApplicationTests {

	@Autowired
	private JobService jobService;

	@Before
	public void createJobs() {
		int lengthBefore = jobService.countAll();
		for (int i = 1; i <= 10000; i++) {
			jobService.createJob("Title t" + i, "description d", "2020-01-01 00:00:00.0", "100", "Beauty", "Cluj-Napoca");
		}
		int lengthAfter = jobService.countAll();

		assert lengthAfter == lengthBefore + 10000;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ignored) {
		}
	}

	@After
	public void tearDown() throws Exception {
		List<Job> addedJobs = jobService.filterJobs("Title t");
		addedJobs.forEach(job -> jobService.deleteJob(job.getId()));
	}

	@Test
	public void getAll() {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i <= 100; i++) {
			executorService.execute(() -> {
				List<Job> allJobs = jobService.getAllJobs();
			});
		}
	}
}
