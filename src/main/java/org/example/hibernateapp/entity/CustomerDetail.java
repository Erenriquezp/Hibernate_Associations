package org.example.hibernateapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean prime;

    @Column(name = "accumulated_points")
    private Long accumulatedPoints;

    @OneToOne
    @JoinColumn(name = "customer_detail_id")
    private Customer customer;

    public CustomerDetail() {
    }

    public CustomerDetail(boolean prime, Long accumulatedPoints) {
        this.prime = prime;
        this.accumulatedPoints = accumulatedPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public Long getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(Long accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerDetail{" +
                "id=" + id +
                ", prime=" + prime +
                ", accumulatedPoints=" + accumulatedPoints +
                '}';
    }
}
