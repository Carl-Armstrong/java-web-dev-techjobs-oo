package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job test_job;
    Job second_test_job;
    Job test_job_all_fields;
    Job second_test_job_all_fields;

    @Before
    public void createJobObjects() {
        test_job = new Job();
        second_test_job = new Job();
        test_job_all_fields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        second_test_job_all_fields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertTrue(second_test_job.getId() - test_job.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", test_job_all_fields.getName());
        assertTrue(test_job_all_fields.getEmployer() instanceof Employer);
        assertEquals("ACME", test_job_all_fields.getEmployer().getValue());
        assertTrue(test_job_all_fields.getLocation() instanceof Location);
        assertEquals("Desert", test_job_all_fields.getLocation().getValue());
        assertTrue(test_job_all_fields.getPositionType() instanceof PositionType);
        assertEquals("Quality control", test_job_all_fields.getPositionType().getValue());
        assertTrue(test_job_all_fields.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test_job_all_fields.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job_all_fields.equals(second_test_job_all_fields));
    }
}