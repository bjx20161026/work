/*
 * TreeGridModel.java was created on 2012-3-15 ����02:59:57
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.modle.old;
/**
 * 
 * @author huwenjiang
 * @version V1.0 2012-3-15 ����03:00:04
 */
public class AcTreeGridModel extends AC {

	private static final long serialVersionUID = -1109847654165351691L;
	
	private String _id; // id
	private String _parent; // �����
	private boolean _is_leaf; 
	private int _lft;
	private int _level;
	private int _rgt;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_parent() {
		return _parent;
	}
	public void set_parent(String _parent) {
		this._parent = _parent;
	}
	public boolean is_is_leaf() {
		return _is_leaf;
	}
	public void set_is_leaf(boolean _is_leaf) {
		this._is_leaf = _is_leaf;
	}
	public int get_lft() {
		return _lft;
	}
	public void set_lft(int _lft) {
		this._lft = _lft;
	}
	public int get_level() {
		return _level;
	}
	public void set_level(int _level) {
		this._level = _level;
	}
	public int get_rgt() {
		return _rgt;
	}
	public void set_rgt(int _rgt) {
		this._rgt = _rgt;
	}

}
