package org.gof.rest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Alex.Chen
 * 这个是rest项目的请求对象例子
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel
public class SampleRequest implements Serializable {

    private static final long serialVersionUID = -1678243481350395333L;
    @XmlElement(name = "id")
    @ApiModelProperty(value = "ID编号",required = true, example = "只接受数字")
    private Long id;

    @XmlElement(name = "type")
    @ApiModelProperty(value = "类型",required = true,example = "类型的分类，1-请求类型1，2-请求类型2")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
