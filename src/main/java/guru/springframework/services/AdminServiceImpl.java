//package guru.springframework.services;
//
//import guru.springframework.domain.Admin;
//
//import guru.springframework.repositories.AdminRepository;
//import guru.springframework.repositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//public class AdminServiceImpl {
//    @Service
//    public class AdmintServiceImpl implements AdminService, guru.springframework.services.AdmintServiceImpl {
//        private AdminRepository adminRepository;
//
//        @Autowired
//        public void setAdminRepository(AdminRepository productRepository) {
//            this.adminRepository = productRepository;
//        }
//
//        @Override
//        public Iterable<Admin> listAllProducts() {
//            return adminRepository.findAll();
//        }
//
//        @Override
//        public Admin getProductById(Integer id) {
//            return (Admin) adminRepository.findById(id).orElse(null);
//        }
//
//        @Override
//        public Admin saveAdminProduct(Admin admin) {
//            return null;
//        }
//
//        public Admin saveProduct(Admin product) {
//            return adminRepository.save(product);
//        }
//    }
//}
