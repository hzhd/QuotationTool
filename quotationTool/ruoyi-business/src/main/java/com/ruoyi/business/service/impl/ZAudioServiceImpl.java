package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZAudioMapper;
import com.ruoyi.business.domain.ZAudio;
import com.ruoyi.business.service.IZAudioService;

/**
 * 音视频库Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
@Service
public class ZAudioServiceImpl implements IZAudioService 
{
    @Autowired
    private ZAudioMapper zAudioMapper;

    /**
     * 查询音视频库
     * 
     * @param audioId 音视频库主键
     * @return 音视频库
     */
    @Override
    public ZAudio selectZAudioByAudioId(Long audioId)
    {
        return zAudioMapper.selectZAudioByAudioId(audioId);
    }

    /**
     * 查询音视频库列表
     * 
     * @param zAudio 音视频库
     * @return 音视频库
     */
    @Override
    public List<ZAudio> selectZAudioList(ZAudio zAudio)
    {
        return zAudioMapper.selectZAudioList(zAudio);
    }

    /**
     * 新增音视频库
     * 
     * @param zAudio 音视频库
     * @return 结果
     */
    @Override
    public int insertZAudio(ZAudio zAudio)
    {
        zAudio.setCreateTime(DateUtils.getNowDate());
        return zAudioMapper.insertZAudio(zAudio);
    }

    /**
     * 修改音视频库
     * 
     * @param zAudio 音视频库
     * @return 结果
     */
    @Override
    public int updateZAudio(ZAudio zAudio)
    {
        zAudio.setUpdateTime(DateUtils.getNowDate());
        return zAudioMapper.updateZAudio(zAudio);
    }

    /**
     * 批量删除音视频库
     * 
     * @param audioIds 需要删除的音视频库主键
     * @return 结果
     */
    @Override
    public int deleteZAudioByAudioIds(Long[] audioIds)
    {
        return zAudioMapper.deleteZAudioByAudioIds(audioIds);
    }

    /**
     * 删除音视频库信息
     * 
     * @param audioId 音视频库主键
     * @return 结果
     */
    @Override
    public int deleteZAudioByAudioId(Long audioId)
    {
        return zAudioMapper.deleteZAudioByAudioId(audioId);
    }
}
