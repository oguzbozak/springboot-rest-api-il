package bozak.oguz.ILService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Il {
    private Date createDate;
    private String id;
    private String name;

}
