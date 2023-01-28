package data;

import entities.enums.Status;
import entities.models.Category;
import entities.models.Pet;
import entities.models.Tag;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataGenerator {

    public static Pet generatePet(){
        Pet pet = Pet.builder()
                .id(generateId())
                .name(generateString(5))
                .category(generateCategory())
                .tags(generateTags(5))
                .photoUrls(generatePhotoUrls(5))
                .status(Status.available)
                .build();
        return pet;
    }

    public static Category generateCategory(){
        Category category = Category.builder()
                .id(generateId())
                .name(generateString(5))
                .build();
        return category;
    }

    public static List<Tag> generateTags(int tagCount){
        List<Tag> tagList = new ArrayList<>();
        Tag tag;
        for (int i = 0; i < tagCount; i++) {
            tag = Tag.builder()
                    .id(generateId())
                    .name(generateString(5))
                    .build();
            tagList.add(tag);
        }
        return tagList;
    }
    public static List<String> generatePhotoUrls(int photoCount){
        List<String> photoList = new ArrayList<>();

        for (int i = 0; i < photoCount; i++) {
            String photoUrl = generateString(20);
            photoList.add(photoUrl);
        }
        return photoList;
    }
    private static Integer generateId(){
        return new Random().nextInt(99999);

    }

    private static String generateString(int nameLenght){
        return RandomStringUtils.randomAlphabetic(nameLenght);
    }
}
