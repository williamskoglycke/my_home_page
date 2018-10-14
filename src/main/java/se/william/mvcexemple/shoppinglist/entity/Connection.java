package se.william.mvcexemple.shoppinglist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Connection {

    @NotNull
    @Size(min=2,max = 30)
    private String toAddress;

    @NotNull
    @Size(min=2,max = 160)
    private String msg;

}
