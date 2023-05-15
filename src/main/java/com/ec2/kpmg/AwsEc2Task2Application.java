package com.ec2.kpmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;

import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;

@SpringBootApplication
public class AwsEc2Task2Application {

	public static void main(String[] args) {
		SpringApplication.run(AwsEc2Task2Application.class, args);
		
	    AmazonEC2 ec2Service = null;
	    String aWSAccessId = "give access Key";
	    String aWSSecretKey = "give secret Key";
	    if (null != aWSAccessId && !"".equals(aWSAccessId)
	            && null != aWSSecretKey && !"".equals(aWSSecretKey)) {
	        ec2Service = new AmazonEC2Client(new BasicAWSCredentials(aWSAccessId, aWSSecretKey));
	    }
	    // This will retrieve particular data key 'public-ipv4' to be retrieve
	    String response = EC2MetadataUtils.getData("/latest/meta-data/public-ipv4");
	    
	     System.out.println("instanceid-----> "+response);



	}

}
