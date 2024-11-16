package tech.chillo.naissances.profiles;

import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    public Profile dtoToEntity(ProfileDTO dto) {
        Profile entity = new Profile();
        entity.setPassword(dto.password());
        entity.setPhone(dto.phone());
        entity.setEmail(dto.email());
        entity.setFirstName(dto.firstName());
        entity.setLastName(dto.lastName());
        return entity;
    }

    public ProfileDTO entityToDto(Profile entity) {
        return new ProfileDTO(
            entity.getCivility(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone(),
                null
        );
    }
}
