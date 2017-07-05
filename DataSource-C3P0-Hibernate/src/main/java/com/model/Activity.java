package com.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author xiangtan
 */
@Entity
@Table(name = "ActivityInfo")
public class Activity {

	/**
	 * 自增主键
	 */
	private Long activityInfoId;
	/**
	 * 活动名称
	 */
	private String name;
	/**
	 * 活动类型
	 */
	private Integer type;
	/**
	 * 发布人ID
	 */
	private Long publisherId;
	/**
	 * 人员限制 是否全选
	 */
	private Byte isAllSelect;
	/**
	 * 最小人数限制
	 */
	private Integer minimum;
	/**
	 * 最大人数限制
	 */
	private Integer maximum;
	/**
	 * 活动说明
	 */
	private String description;
	/**
	 * 报名开始时间
	 */
	private Date beginTime;
	/**
	 * 报名结束时间
	 */
	private Date endTime;
	/**
	 * 活动时间
	 */
	private Date activityTime;
	/**
	 * 活动状态
	 */
	private Integer status;
	/**
	 * 逻辑删除标识符
	 */
	private Byte enumDataEntityStatus;
	/**
	 * 创建者
	 */
	private String createOperator;
	/**
	 * 创建者ID
	 */
	private Long createOperatorId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后更新者
	 */
	private String lastUpdateOperator;
	/**
	 * 最后更新者ID
	 */
	private Long lastUpdateOperatorId;
	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ActivityInfoId")
	public Long getActivityInfoId() {
		return activityInfoId;
	}

	public void setActivityInfoId(Long activityInfoId) {
		this.activityInfoId = activityInfoId;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "PublisherId")
	public Long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}

	@Column(name = "IsAllSelect")
	public Byte getIsAllSelect() {
		return isAllSelect;
	}

	public void setIsAllSelect(Byte isAllSelect) {
		this.isAllSelect = isAllSelect;
	}

	@Column(name = "Minimum")
	public Integer getMinimum() {
		return minimum;
	}

	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}

	@Column(name = "Maximum")
	public Integer getMaximum() {
		return maximum;
	}

	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "BeginTime")
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "EndTime")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "ActivityTime")
	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	@Column(name = "Status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "EnumDataEntityStatus")
	public Byte getEnumDataEntityStatus() {
		return enumDataEntityStatus;
	}

	public void setEnumDataEntityStatus(Byte enumDataEntityStatus) {
		this.enumDataEntityStatus = enumDataEntityStatus;
	}

	@Column(name = "CreateOperator")
	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}

	@Column(name = "CreateOperatorId")
	public Long getCreateOperatorId() {
		return createOperatorId;
	}

	public void setCreateOperatorId(Long createOperatorId) {
		this.createOperatorId = createOperatorId;
	}

	@Column(name = "CreateTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "LastUpdateOperator")
	public String getLastUpdateOperator() {
		return lastUpdateOperator;
	}

	public void setLastUpdateOperator(String lastUpdateOperator) {
		this.lastUpdateOperator = lastUpdateOperator;
	}

	@Column(name = "LastUpdateOperatorId")
	public Long getLastUpdateOperatorId() {
		return lastUpdateOperatorId;
	}

	public void setLastUpdateOperatorId(Long lastUpdateOperatorId) {
		this.lastUpdateOperatorId = lastUpdateOperatorId;
	}

	@Column(name = "LastUpdateTime")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}