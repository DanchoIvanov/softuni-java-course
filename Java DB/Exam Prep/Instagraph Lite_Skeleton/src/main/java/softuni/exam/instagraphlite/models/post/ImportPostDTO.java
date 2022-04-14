package softuni.exam.instagraphlite.models.post;

import softuni.exam.instagraphlite.models.picture.PictureDTO;
import softuni.exam.instagraphlite.models.user.UserDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPostDTO {

    @NotNull
    @Size(min = 21)
    private String caption;

    private UserDTO user;

    private PictureDTO picture;

    public String getCaption() {
        return caption;
    }

    public UserDTO getUser() {
        return user;
    }

    public PictureDTO getPicture() {
        return picture;
    }
}
