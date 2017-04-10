package com.example.api;

/**
 * Created by lxl on 2017/3/29.
 */

public class ApiConfiguration {

    private int dataSourceType;

    private ApiConfiguration(Builder builder){

    }

    public static final class Builder{

        private int dataSourceType;

        private Builder(){

        }

        public ApiConfiguration build(){
            return new ApiConfiguration(this);
        }

        public Builder dataSourceType(int dataSourceType){
            this.dataSourceType = dataSourceType;
            return this;
        }
    }
}
