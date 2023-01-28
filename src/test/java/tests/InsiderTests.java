package tests;

import data.TestDataGenerator;
import entities.models.Pet;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InsiderTests extends BaseTest{

    @Test(groups = "happy tests")
    void createAndReadPet() {

        //generate a pet
        Pet pet = TestDataGenerator.generatePet();
        response = postRequest(pet);
        //assertions
        Assert.assertEquals(response.body().as(Pet.class).getId(),pet.getId());
        Assert.assertEquals(response.body().as(Pet.class).getName(),pet.getName());
        Assert.assertEquals(response.body().as(Pet.class).getStatus(),pet.getStatus());
        Assert.assertEquals(response.body().as(Pet.class).getCategory().getName(),pet.getCategory().getName());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        //read the generated pet
        response = getRequest(pet.getId().toString());
        //assertions
        Assert.assertEquals(response.body().as(Pet.class).getId(),pet.getId());
        Assert.assertEquals(response.body().as(Pet.class).getName(),pet.getName());
        Assert.assertEquals(response.body().as(Pet.class).getStatus(),pet.getStatus());
        Assert.assertEquals(response.body().as(Pet.class).getCategory().getName(),pet.getCategory().getName());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }

    @Test(groups = "happy tests")
    void updateAndReadPet() {
        //generate a pet
        Pet pet = TestDataGenerator.generatePet();
        postRequest(pet);

        //update the name of the pet object
        pet.setName(pet.getName() + "updated");

        //update the generated pet
        response = putRequest(pet);
        //assertions
        Assert.assertEquals(response.body().as(Pet.class).getId(),pet.getId());
        Assert.assertEquals(response.body().as(Pet.class).getName(),pet.getName());
        Assert.assertEquals(response.body().as(Pet.class).getCategory().getName(),pet.getCategory().getName());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);


        //check the updated pet
        response = getRequest(pet.getId().toString());

        //assertions
        Assert.assertEquals(response.body().as(Pet.class).getId(),pet.getId());
        Assert.assertEquals(response.body().as(Pet.class).getName(),pet.getName());
        Assert.assertEquals(response.body().as(Pet.class).getCategory().getName(),pet.getCategory().getName());
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);
    }

    @Test(groups = "happy tests")
    void deleteAndCheckPet() {
        //generate a pet
        Pet pet = TestDataGenerator.generatePet();
        postRequest(pet);

        //delete the generated pet
        response = deleteRequest(pet.getId().toString());
        //assertions
        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK);

        //check the deleted pet
        response = getRequest(pet.getId().toString());

        //assertions
        Assert.assertEquals(response.statusCode(),HttpStatus.SC_NOT_FOUND);

    }


}
