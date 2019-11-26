package com.netcracker.event.service;

import com.netcracker.event.domain.Organization;
import com.netcracker.event.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class OrganizationService {
    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository=organizationRepository;
    }

    public Organization findByOrganizationId(UUID id) {
        return organizationRepository.findByOrganizationId(id);
    }

    public String getOrganizationInfo(UUID id) {
        return organizationRepository.findByOrganizationId(id).getInfo();
    }

    public void saveOrganization(Organization organization) {
        organizationRepository.save(organization);
    }

    public Organization getOrganizationByUser(String userId) {
        return organizationRepository.findOrganizationByUserId(userId);
    }

    public byte[] extractBytes (String ImageName) throws IOException {
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
        return ( data.getData() );
    }
}