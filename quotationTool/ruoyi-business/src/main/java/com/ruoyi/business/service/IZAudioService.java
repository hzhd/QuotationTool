package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.ZAudio;

/**
 * 音视频库Service接口
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
public interface IZAudioService 
{
    /**
     * 查询音视频库
     * 
     * @param audioId 音视频库主键
     * @return 音视频库
     */
    public ZAudio selectZAudioByAudioId(Long audioId);

    /**
     * 查询音视频库列表
     * 
     * @param zAudio 音视频库
     * @return 音视频库集合
     */
    public List<ZAudio> selectZAudioList(ZAudio zAudio);

    /**
     * 新增音视频库
     * 
     * @param zAudio 音视频库
     * @return 结果
     */
    public int insertZAudio(ZAudio zAudio);

    /**
     * 修改音视频库
     * 
     * @param zAudio 音视频库
     * @return 结果
     */
    public int updateZAudio(ZAudio zAudio);

    /**
     * 批量删除音视频库
     * 
     * @param audioIds 需要删除的音视频库主键集合
     * @return 结果
     */
    public int deleteZAudioByAudioIds(Long[] audioIds);

    /**
     * 删除音视频库信息
     * 
     * @param audioId 音视频库主键
     * @return 结果
     */
    public int deleteZAudioByAudioId(Long audioId);
}
