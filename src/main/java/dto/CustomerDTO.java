package dto;

import javax.validation.constraints.NotBlank;

public class CustomerDTO {


    int id;
    @NotBlank(message = "Name cannot be blank")
    String name;

    public CustomerDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
