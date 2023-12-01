package nl.hw.hwtechiteasy.services;

import nl.hw.hwtechiteasy.Model.Television;
import nl.hw.hwtechiteasy.Repository.TelevisionRepository;
import nl.hw.hwtechiteasy.dto.TelevisionDto;
import nl.hw.hwtechiteasy.exceptions.RecordNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public TelevisionDto createTelevision (TelevisionDto televisionDto) {
        Television television = new Television();
        television.setType(televisionDto.type);
        television.setBrand(televisionDto.brand);
        television.setName(televisionDto.name);
        television.setPrice(televisionDto.price);
        television.setAvailableSize(televisionDto.availableSize);
        television.setRefreshRate(televisionDto.refreshRate);
        television.setScreenType(televisionDto.screenType);
        television.setScreenQuality(televisionDto.screenQuality);
        television.setSmartTv(televisionDto.smartTv);
        television.setWifi(televisionDto.wifi);
        television.setVoiceControl(televisionDto.voiceControl);
        television.setHdr(televisionDto.hdr);
        television.setBluetooth(televisionDto.bluetooth);
        television.setAmbiLight(televisionDto.ambiLight);
        television.setOriginalStock(televisionDto.originalStock);
        television.setSold(televisionDto.sold);

        repos.save(television);
        televisionDto.id = television.getId();

        return televisionDto;
    }

//    public TelevisionDto createTelevision (TelevisionDto televisionDto) {
//        Television television = new Television();
//        television.setType(createTelevisionDto.type);
//    }
//
//    public List<Television> getTelevisions() {
//        return ListOfTelevisions.getTelevisions();
//
//    }
//
//    public Television getTelevision(int id) {
//        Television televisionFound = ListOfTelevisions.getTelevision(id);
//        if (televisionFound == null)
//            throw new RecordNotFoundException("Can not find television");
//        return televisionFound;
//    }
//
//    public int addTelevision (Television television) {
//        return ListOfTelevisions.addTelevision(television);
//    }






}
