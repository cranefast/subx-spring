package kr.co.subx.repository;


import kr.co.subx.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findCompanyByBusinessNumber(String businessNumber);

}
