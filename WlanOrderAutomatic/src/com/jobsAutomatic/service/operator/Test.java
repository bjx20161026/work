package com.jobsAutomatic.service.operator;

import com.jobsAutomatic.service.operator.hotspots.HotReviewOutService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new HotApplyNetService().ApplyNetService("SH-206-170109-00008");
//		System.out.println("热点入网申请完成");
//		new HotReviewNetService().ReviewNetService("SH-206-170109-00008");
//		System.out.println("热点入网审核完成");
//		new HotOutApplyService().OutApplytService("SH-206-170109-00003");
//		System.out.println("热点退服申请完成");
		new HotReviewOutService().ReviewOutService("SH-206-170109-00003");
		System.out.println("热点退服审核完成");
//		new ApApplyNetService().ApplyNetService("SH-206-170109-00010");
//		System.out.println("AP入网申请完成");
//		new ApReviewNetService().ReviewNetService("SH-206-170109-00010");
//		System.out.println("AP入网审核完成");
//		new ApOutApplyService().OutApplytService("SH-206-170109-00011");
//		System.out.println("AP退服申请完成");
//		new ApReviewOutService().OutApplytService("SH-206-170109-00011");
//		System.out.println("AP退服审核完成");
	}
}
