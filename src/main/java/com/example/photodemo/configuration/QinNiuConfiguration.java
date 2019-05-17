package com.example.photodemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 七牛云配置信息
 *
 * @author zmt
 * @date 2019-03-19 14:13
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QinNiuConfiguration {

    private String bucketName;
    private String domainOfBucket;
    private String contractBucketName;
    private String contractDomainOfBucket;
    private String zipBucketName;
    private String zipDomainOfBucket;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDomainOfBucket() {
        return domainOfBucket;
    }

    public void setDomainOfBucket(String domainOfBucket) {
        this.domainOfBucket = domainOfBucket;
    }

    public String getContractBucketName() {
        return contractBucketName;
    }

    public void setContractBucketName(String contractBucketName) {
        this.contractBucketName = contractBucketName;
    }

    public String getContractDomainOfBucket() {
        return contractDomainOfBucket;
    }

    public void setContractDomainOfBucket(String contractDomainOfBucket) {
        this.contractDomainOfBucket = contractDomainOfBucket;
    }

    public String getZipBucketName() {
        return zipBucketName;
    }

    public void setZipBucketName(String zipBucketName) {
        this.zipBucketName = zipBucketName;
    }

    public String getZipDomainOfBucket() {
        return zipDomainOfBucket;
    }

    public void setZipDomainOfBucket(String zipDomainOfBucket) {
        this.zipDomainOfBucket = zipDomainOfBucket;
    }

    @Override
    public String toString() {
        return "QinNiuConfig{" +
                "bucketName='" + bucketName + '\'' +
                ", domainOfBucket='" + domainOfBucket + '\'' +
                ", contractBucketName='" + contractBucketName + '\'' +
                ", contractDomainOfBucket='" + contractDomainOfBucket + '\'' +
                ", zipBucketName='" + zipBucketName + '\'' +
                ", zipDomainOfBucket='" + zipDomainOfBucket + '\'' +
                '}';
    }
}
