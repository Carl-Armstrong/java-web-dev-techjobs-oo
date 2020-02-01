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
    Job test_job_empty_fields;

    @Before
    public void createJobObjects() {
        test_job = new Job();
        second_test_job = new Job();
        test_job_all_fields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        second_test_job_all_fields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job_empty_fields = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency("Testing"));
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

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        assertTrue(test_job_all_fields.toString().startsWith("\n", 0));
        assertTrue(test_job_all_fields.toString().endsWith("\n"));
    }

    @Test
    public void testToStringFormattedAndFilledCorrectly() {
        assertEquals("\nID: " + test_job_all_fields.getId() +
                "\nName: " + test_job_all_fields.getName() +
                "\nEmployer: " + test_job_all_fields.getEmployer() +
                "\nLocation: " + test_job_all_fields.getLocation() +
                "\nPosition Type: " + test_job_all_fields.getPositionType() +
                "\nCore Competency: " + test_job_all_fields.getCoreCompetency() +
                "\n",
                test_job_all_fields.toString());
    }

    @Test
    public void testToStringInformsOfEmptyField() {
        assertEquals("\nID: " + test_job_empty_fields.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: " + test_job_empty_fields.getCoreCompetency() +
                "\n",
                test_job_empty_fields.toString());
    }

    @Test
    public void testToStringInformsIfOnlyIdIsSet() {
        assertEquals("\nThis job does not seem to exist.\n", test_job.toString());
    }
}