package com.rak.agora.orderservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.math.BigInteger;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private BigInteger id;

  @CreationTimestamp
  private Instant createdOn;

  @UpdateTimestamp
  private Instant updatedOn;
}
