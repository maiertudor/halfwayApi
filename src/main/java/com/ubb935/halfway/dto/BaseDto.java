package com.ubb935.halfway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Laura on 10/31/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseDto implements Serializable{
    protected String id = null;
}
