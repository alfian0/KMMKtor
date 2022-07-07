//
//  ViewController.swift
//  iosApp
//
//  Created by M. Alfiansyah Nur Cahya Putra on 06/07/22.
//

import UIKit
import shared

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        MainRepository().search { result, error in
            print(result?.first?.name, error?.localizedDescription)
        }
    }


}

