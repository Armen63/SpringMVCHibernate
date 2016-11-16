package com.journaldev.spring;

import com.journaldev.spring.model.Address;
        import com.journaldev.spring.service.AddressService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressController {
    private AddressService addressService;

    @Autowired(required=true)
    @Qualifier(value="AddressService")
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value= "/address/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("address") Address a ){

        if(a.getId() == 0){
            //new person, add it
            this.addressService.addAddress(a);
        }else{
            //existing person, call update
            this.addressService.updateAddress(a);
        }

        return "redirect:/viewa_addresses/"+a.getPersonId();

    }


    @RequestMapping("address/remove/{id}")
    public String removeAddress(@PathVariable("id") int id){

        this.addressService.removeAddress(id);
        return "redirect:/addresses";
    }

    @RequestMapping("/edit/address/{id}")
    public String editAddress(@PathVariable("id") int id, Model model){
        model.addAttribute("address", this.addressService.getAddressById(id));
        model.addAttribute("listAddress", this.addressService.listAddresses());
        return "addresses";
    }
//    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
//    public String listAddresses(Model model) {
//        return "redirect:/viewa_addresses/{id}";
//    }
}