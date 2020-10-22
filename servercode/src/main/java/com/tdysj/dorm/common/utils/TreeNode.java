package com.tdysj.dorm.common.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建树节点
 * @author Create by yachtcay
 * @date 2019/6/4 16:37
 */
@Data
public class TreeNode {
	/**
	 * id
	 */
	protected String id;
	/**
	 * 父级id
	 */
	protected String parentId;
	/**
	 * 子集
	 */
	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
