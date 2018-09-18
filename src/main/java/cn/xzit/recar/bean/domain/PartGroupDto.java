package cn.xzit.recar.bean.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartGroupDto {
    private int partGroupid;
    private String groupName;
    private String pGroupName;
    private Integer preid;
}
