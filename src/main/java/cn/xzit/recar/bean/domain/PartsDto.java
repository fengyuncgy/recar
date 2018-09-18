package cn.xzit.recar.bean.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartsDto {
    private int partid;
    private String partName;
    private String specification;
    private Integer partGroupid;
    private String groupName;
    private Integer manufacturerid;
    private String name;
}
