package app;

import javax.persistence.*;

@Entity
@Table(name = "test_table")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    public TestEntity() {
    }

    public TestEntity(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
